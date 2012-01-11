/*
 * Copyright 2011 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package io.netty.handler.ipfilter;

import java.net.InetAddress;
import java.net.UnknownHostException;

/** IpV4 only Filter Rule */
public class IpV4SubnetFilterRule extends IpV4Subnet implements IpFilterRule {
    /** Is this IpV4Subnet an ALLOW or DENY rule */
    private boolean isAllowRule = true;

    /**
     * Constructor for a ALLOW or DENY ALL
     *
     * @param allow True for ALLOW, False for DENY
     */
    public IpV4SubnetFilterRule(boolean allow) {
        isAllowRule = allow;
    }

    /** @param allow True for ALLOW, False for DENY */
    public IpV4SubnetFilterRule(boolean allow, InetAddress inetAddress, int cidrNetMask) {
        super(inetAddress, cidrNetMask);
        isAllowRule = allow;
    }

    /** @param allow True for ALLOW, False for DENY */
    public IpV4SubnetFilterRule(boolean allow, InetAddress inetAddress, String netMask) {
        super(inetAddress, netMask);
        isAllowRule = allow;
    }

    /** @param allow True for ALLOW, False for DENY */
    public IpV4SubnetFilterRule(boolean allow, String netAddress) throws UnknownHostException {
        super(netAddress);
        isAllowRule = allow;
    }

    @Override
    public boolean isAllowRule() {
        return isAllowRule;
    }

    @Override
    public boolean isDenyRule() {
        return !isAllowRule;
    }

}
