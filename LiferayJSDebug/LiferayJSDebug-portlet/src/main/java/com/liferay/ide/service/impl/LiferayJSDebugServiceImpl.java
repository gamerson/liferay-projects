package com.liferay.ide.service.impl;

import com.liferay.ide.service.base.LiferayJSDebugServiceBaseImpl;
import com.liferay.portal.kernel.util.FileUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * The implementation of the liferay j s debug remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.ide.service.LiferayJSDebugService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.ide.service.base.LiferayJSDebugServiceBaseImpl
 * @see com.liferay.ide.service.LiferayJSDebugServiceUtil
 */
public class LiferayJSDebugServiceImpl extends LiferayJSDebugServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.liferay.ide.service.LiferayJSDebugServiceUtil} to access the liferay j s debug remote service.
     */
    private static class Node
    {
        final String name;
        final List<String> props = new ArrayList<String>();

        public Node(String n)
        {
            this.name = n;
        }
    }

    public void debugJS( String log )
    {
        BufferedReader bf = new BufferedReader( new StringReader( log ) );

        List<String> lines = new ArrayList<String>();

        do
        {
            try
            {
                lines.add( bf.readLine() );
            }
            catch( IOException e )
            {
            }

        }
        while( lines.get( lines.size() -1 ) != null );

        lines.remove( lines.size() - 1 ); // remove null

        List<Node> nodes = new ArrayList<Node>();

        for( String line : lines )
        {
            if( line.startsWith( "\"" ) )
            {
                nodes.add( new Node(line) );
            }
            else
            {
                nodes.get( nodes.size() - 1 ).props.add( line );
            }
        }

        Node[] nodeArray = nodes.toArray( new Node[0] );

        Arrays.sort( nodeArray, new Comparator<Node>()
        {
            public int compare( Node o1, Node o2 )
            {
                return o1.name.compareTo( o2.name );
            }
        });

        try
        {
            StringBuffer sb = new StringBuffer();

            for(Node n : nodeArray)
            {
                sb.append( n.name + "\n");

                for( String p : n.props)
                {
                    sb.append( p + "\n");
                }
            }

            FileUtil.write( new File("/lrdev/tmp/logOutput.txt"), sb.toString(), true );
        }
        catch( IOException e )
        {
        }
    }
}
