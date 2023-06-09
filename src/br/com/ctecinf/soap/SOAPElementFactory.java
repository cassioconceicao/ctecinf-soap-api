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
 * {@code SOAPElementFactory} is a factory for XML fragments that
 * will eventually end up in the SOAP part. These fragments
 * can be inserted as children of the {@code SOAPHeader} or
 * {@code SOAPBody} or {@code SOAPEnvelope}.
 *
 * <p>Elements created using this factory do not have the properties
 * of an element that lives inside a SOAP header document. These
 * elements are copied into the XML document tree when they are
 * inserted.
 * @deprecated - Use {@code javax.xml.soap.SOAPFactory} for creating SOAPElements.
 * @see br.com.ctecinf.javax.xml.soap.SOAPFactory
 * @since 1.6
 */
public class SOAPElementFactory {

    private SOAPFactory soapFactory;

    private SOAPElementFactory(SOAPFactory soapFactory) {
        this.soapFactory = soapFactory;
    }

    /**
     * Create a {@code SOAPElement} object initialized with the
     * given {@code Name} object.
     *
     * @param name a {@code Name} object with the XML name for
     *             the new element
     *
     * @return the new {@code SOAPElement} object that was
     *         created
     *
     * @exception SOAPException if there is an error in creating the
     *            {@code SOAPElement} object
     *
     * @deprecated Use
     * javax.xml.soap.SOAPFactory.createElement(javax.xml.soap.Name)
     * instead
     *
     * @see javax.xml.soap.SOAPFactory#createElement(javax.xml.soap.Name)
     * @see javax.xml.soap.SOAPFactory#createElement(javax.xml.namespace.QName)
     */
    public SOAPElement create(Name name) throws SOAPException {
        return soapFactory.createElement(name);
    }

    /**
     * Create a {@code SOAPElement} object initialized with the
     * given local name.
     *
     * @param localName a {@code String} giving the local name for
     *             the new element
     *
     * @return the new {@code SOAPElement} object that was
     *         created
     *
     * @exception SOAPException if there is an error in creating the
     *            {@code SOAPElement} object
     *
     * @deprecated Use
     * javax.xml.soap.SOAPFactory.createElement(String localName) instead
     *
     * @see javax.xml.soap.SOAPFactory#createElement(java.lang.String)
     */
    public SOAPElement create(String localName) throws SOAPException {
        return soapFactory.createElement(localName);
    }

    /**
     * Create a new {@code SOAPElement} object with the given
     * local name, prefix and uri.
     *
     * @param localName a {@code String} giving the local name
     *                  for the new element
     * @param prefix the prefix for this {@code SOAPElement}
     * @param uri a {@code String} giving the URI of the
     *            namespace to which the new element belongs
     *
     * @return the new {@code SOAPElement} object that was
     *         created
     *
     * @exception SOAPException if there is an error in creating the
     *            {@code SOAPElement} object
     *
     * @deprecated Use
     * javax.xml.soap.SOAPFactory.createElement(String localName,
     *                      String prefix,
     *                      String uri)
     * instead
     *
     * @see javax.xml.soap.SOAPFactory#createElement(java.lang.String, java.lang.String, java.lang.String)
     */
    public SOAPElement create(String localName, String prefix, String uri)
        throws SOAPException {
        return soapFactory.createElement(localName, prefix, uri);
    }

    /**
     * Creates a new instance of {@code SOAPElementFactory}.
     *
     * @return a new instance of a {@code SOAPElementFactory}
     *
     * @exception SOAPException if there was an error creating the
     *            default {@code SOAPElementFactory}
     */
    public static SOAPElementFactory newInstance() throws SOAPException {
        try {
            return new SOAPElementFactory(SOAPFactory.newInstance());
        } catch (Exception ex) {
            throw new SOAPException(
                "Unable to create SOAP Element Factory: " + ex.getMessage());
        }
    }
}
