/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2004-2017 Oracle and/or its affiliates. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License.  You can
 * obtain a copy of the License at
 * https://oss.oracle.com/licenses/CDDL+GPL-1.1
 * or LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at LICENSE.txt.
 *
 * GPL Classpath Exception:
 * Oracle designates this particular file as subject to the "Classpath"
 * exception as provided by Oracle in the GPL Version 2 section of the License
 * file that accompanied this code.
 *
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * Contributor(s):
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */

package br.com.ctecinf.soap;


/**
 * A factory for creating {@code SOAPConnection} objects. Implementation of this class
 * is optional. If {@code SOAPConnectionFactory.newInstance()} throws an
 * UnsupportedOperationException then the implementation does not support the
 * SAAJ communication infrastructure. Otherwise {@link SOAPConnection} objects
 * can be created by calling {@code createConnection()} on the newly
 * created {@code SOAPConnectionFactory} object.
 *
 * @since 1.6
 */
public abstract class SOAPConnectionFactory {

    /**
     * A constant representing the default value for a {@code SOAPConnection}
     * object. The default is the point-to-point SOAP connection.
     */
    private static final String DEFAULT_SOAP_CONNECTION_FACTORY
            = "com.sun.xml.internal.messaging.saaj.client.p2p.HttpSOAPConnectionFactory";

    /**
     * Creates an instance of the default
     * {@code SOAPConnectionFactory} object.
     *
     * This method uses the lookup procedure specified in {@link br.com.ctecinf.javax.xml.soap} to locate and load the
     * {@link br.com.ctecinf.javax.xml.soap.SOAPConnectionFactory} class.
     *
     * @return a new instance of a default
     *         {@code SOAPConnectionFactory} object
     *
     * @exception SOAPException if there was an error creating the
     *            {@code SOAPConnectionFactory}
     *
     * @exception UnsupportedOperationException if newInstance is not
     * supported.
     */
    public static SOAPConnectionFactory newInstance()
        throws SOAPException, UnsupportedOperationException
    {
        try {
            return FactoryFinder.find(
                    SOAPConnectionFactory.class,
                    DEFAULT_SOAP_CONNECTION_FACTORY,
                    true);
        } catch (Exception ex) {
            throw new SOAPException("Unable to create SOAP connection factory: "
                                    +ex.getMessage());
        }
    }

    /**
     * Create a new {@code SOAPConnection}.
     *
     * @return the new {@code SOAPConnection} object.
     *
     * @exception SOAPException if there was an exception creating the
     * {@code SOAPConnection} object.
     */
    public abstract SOAPConnection createConnection()
        throws SOAPException;
}
