package com.heartstone.structure.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/**
 * @author code generator
 * @date 2022-05-30 16:36
 */
public class NioSocket {


    public void server(int port){
        try (final ServerSocketChannel socketChannel = ServerSocketChannel.open()){
            socketChannel.configureBlocking(false);
            ServerSocket socket = socketChannel.socket();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(port);
            socket.bind(inetSocketAddress);
            Selector selector = Selector.open();
            socketChannel.register(selector, SelectionKey.OP_ACCEPT);
            selector.select();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
