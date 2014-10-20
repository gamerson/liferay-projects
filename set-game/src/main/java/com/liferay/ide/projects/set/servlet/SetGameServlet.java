//This sample is how to use websocket of Tomcat.
package com.liferay.ide.projects.set.servlet;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.websocket.MessageInbound;
import org.apache.catalina.websocket.StreamInbound;
import org.apache.catalina.websocket.WebSocketServlet;
import org.apache.catalina.websocket.WsOutbound;

import com.liferay.ide.projects.set.SetGame;

public class SetGameServlet extends WebSocketServlet {
    private static final long serialVersionUID = 1L;
    private static Map<String, MyMessageInbound> endpoints = new HashMap<String, SetGameServlet.MyMessageInbound>();
    private static Map<String, SetGame> setGames = new HashMap<String, SetGame>();

    @Override
    public StreamInbound createWebSocketInbound(String protocol, HttpServletRequest arg1) {
        return new MyMessageInbound(arg1.getParameter("userId"));
    }

    private class MyMessageInbound extends MessageInbound {
        WsOutbound myoutbound;
        private String endpointUserId;

        public MyMessageInbound(String userId) {
            this.endpointUserId = userId;
        }

        @Override
        public void onOpen(WsOutbound outbound) {
            this.myoutbound = outbound;
            endpoints.put(endpointUserId, this);

            SetGame setGame = setGames.get(endpointUserId);

            if( setGame != null ) {
                MyMessageInbound inviteEndpoint = endpoints.get(setGame.getInviteUserId());

                if(inviteEndpoint != null ) {
                    try {
                        inviteEndpoint.myoutbound.writeTextMessage(CharBuffer.wrap("joinGame " + setGame.getStartUserId()));
                        inviteEndpoint.myoutbound.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        @Override
        public void onClose(int status) {
            endpoints.remove(endpointUserId);
        }

        @Override
        public void onTextMessage(CharBuffer cb) throws IOException {
            final String message = cb.toString();
            StringTokenizer tokenizer = new StringTokenizer(message, " ");
            String cmd = tokenizer.nextToken();

            if ("startGame".equals(cmd)) {
                String startUserId = tokenizer.nextToken();
                String inviteUserId = tokenizer.nextToken();
                String gameData = message.substring(message.indexOf(inviteUserId) + inviteUserId.length()).trim();

                SetGame newGame = new SetGame(startUserId, inviteUserId, gameData);
                setGames.put(startUserId, newGame);
                setGames.put(inviteUserId, newGame);
            }
            else if("ready".equals(cmd)) {
                SetGame setGame = setGames.get(this.endpointUserId);
                endpoints.get(endpointUserId).myoutbound.writeTextMessage(CharBuffer.wrap("gameData " + setGame.getGameData()));
                endpoints.get(endpointUserId).myoutbound.flush();
            }
            else if("start".equals(cmd)) {
                for( String userId : endpoints.keySet() ) {
                    if(!userId.equals(endpointUserId)) {
                        endpoints.get(userId).myoutbound.writeTextMessage(CharBuffer.wrap("start"));
                        endpoints.get(userId).myoutbound.flush();
                    }
                }
            }
            else if("foundSet".equals(cmd)) {
                for( String userId : endpoints.keySet() ) {
                    if(!userId.equals(endpointUserId)) {
                        endpoints.get(userId).myoutbound.writeTextMessage(CharBuffer.wrap(message));
                        endpoints.get(userId).myoutbound.flush();
                    }
                }
            }
            else {
                System.out.println(cmd);
            }
        }

        @Override
        public void onBinaryMessage(ByteBuffer bb) throws IOException {
        }
    }
}
