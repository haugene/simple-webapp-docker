package com.capgemini.no.dockerfun.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by kristian on 29.05.14.
 */
public class HostnameResolver
{
    public String getHostname()
    {
        String hostname;

        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            hostname = inetAddress.getCanonicalHostName();
        } catch (UnknownHostException e) {
            hostname = "Unknown host, got exception";
        }

        return hostname;
    }
}
