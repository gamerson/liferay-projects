//This sample is how to use websocket of Tomcat.
package com.liferay.ide.projects.set.servlet;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.websocket.MessageInbound;
import org.apache.catalina.websocket.StreamInbound;
import org.apache.catalina.websocket.WebSocketServlet;
import org.apache.catalina.websocket.WsOutbound;

import com.liferay.ide.projects.set.SetGame;

public class SetGameServlet extends WebSocketServlet
{
    private static final long serialVersionUID = 1L;
    private static ArrayList<MyMessageInbound> mmiList = new ArrayList<MyMessageInbound>();
    private static Map<String, SetGame> setGames = new HashMap<String, SetGame>();

    @Override
    public StreamInbound createWebSocketInbound(String protocol, HttpServletRequest arg1)
    {
        return new MyMessageInbound();
    }

    private class MyMessageInbound extends MessageInbound
    {
        WsOutbound myoutbound;

        @Override
        public void onOpen(WsOutbound outbound){
            this.myoutbound = outbound;
            mmiList.add(this);
        }

        @Override
        public void onClose(int status){
            mmiList.remove(this);
        }

        @Override
        public void onTextMessage(CharBuffer cb) throws IOException{
    		final String message = cb.toString();
			StringTokenizer tokenizer = new StringTokenizer(message, " ");
        	String cmd = tokenizer.nextToken();

        	if( "startGame".equals(cmd) )
        	{
        		String startUserId = tokenizer.nextToken();
        		String inviteUserId = tokenizer.nextToken();
        		String gameData = message.substring(message.indexOf(inviteUserId));

        		SetGame setGame = setGames.get(startUserId);

        		if( setGame == null )
        		{
        			setGame = new SetGame(startUserId, inviteUserId, gameData);
        			setGames.put(startUserId, setGame);
        		}
        	}

            for(MyMessageInbound mmib: mmiList){
                CharBuffer buffer = CharBuffer.wrap(cb);

                //mmib.myoutbound.writeTextMessage(buffer);
                //mmib.myoutbound.writeTextMessage(CharBuffer.wrap("response"));
                //mmib.myoutbound.flush();
            }
        }

        @Override
        public void onBinaryMessage(ByteBuffer bb) throws IOException{
        }
    }
}
