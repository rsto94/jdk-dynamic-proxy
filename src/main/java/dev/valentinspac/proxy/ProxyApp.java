package dev.valentinspac.proxy;

import dev.valentinspac.proxy.framework.ProxyFactory;
import dev.valentinspac.proxy.service.Playable;
import dev.valentinspac.proxy.service.Seekable;

import java.io.File;

public class ProxyApp {

    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory(ProxyApp.class.getPackage());

        File file = new File("SongPath");
        Playable playable = proxyFactory.getBean(Playable.class);
        System.out.println("playable.play(file.getPath())");
        playable.play(file.getPath());

        System.out.println();
        System.out.println("playable.play(file)");
        playable.play(file);

        System.out.println();
        System.out.println("playable.play(file, 10)");
        playable.play(file, 10);

        System.out.println();
        System.out.println("playable.play(file, 10, 15)");
        playable.play(file, 10, 15);


        Seekable seekablePlayer = proxyFactory.getBean(Seekable.class);
        System.out.println();
        System.out.println("seekablePlayer.seekTo(20)");
        seekablePlayer.seekTo(20);
    }

}
