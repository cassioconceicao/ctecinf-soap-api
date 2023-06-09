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
 * The container for the SOAPHeader and SOAPBody portions of a
 * {@code SOAPPart} object. By default, a {@code SOAPMessage}
 * object is created with a {@code SOAPPart} object that has a
 * {@code SOAPEnvelope} object. The {@code SOAPEnvelope} object
 * by default has an empty {@code SOAPBody} object and an empty
 * {@code SOAPHeader} object.  The {@code SOAPBody} object is
 * required, and the {@code SOAPHeader} object, though
 * optional, is used in the majority of cases. If the
 * {@code SOAPHeader} object is not needed, it can be deleted,
 * which is shown later.
 * <P>
 * A client can access the {@code SOAPHeader} and {@code SOAPBody}
 * objects by calling the methods {@code SOAPEnvelope.getHeader} and
 * {@code SOAPEnvelope.getBody}. The
 * following  lines of code use these two methods after starting with
 * the {@code SOAPMessage}
 * object <i>message</i> to get the {@code SOAPPart} object <i>sp</i>,
 * which is then used to get the {@code SOAPEnvelope} object <i>se</i>.
 *
 * <pre>{@code
 *     SOAPPart sp = message.getSOAPPart();
 *     SOAPEnvelope se = sp.getEnvelope();
 *     SOAPHeader sh = se.getHeader();
 *     SOAPBody sb = se.getBody();
 * }</pre>
 * <P>
 * It is possible to change the body or header of a {@code SOAPEnvelope}
 * object by retrieving the current one, deleting it, and then adding
 * a new body or header. The {@code javax.xml.soap.Node} method
 * {@code deleteNode} deletes the XML element (node) on which it is
 * called.  For example, the following line of code deletes the
 * {@code SOAPBody} object that is retrieved by the method {@code getBody}.
 * <pre>{@code
 *      se.getBody().detachNode();
 * }</pre>
 * To create a {@code SOAPHeader} object to replace the one that was removed,
 * a client uses
 * the method {@code SOAPEnvelope.addHeader}, which creates a new header and
 * adds it to the {@code SOAPEnvelope} object. Similarly, the method
 * {@code addBody} creates a new {@code SOAPBody} object and adds
 * it to the {@code SOAPEnvelope} object. The following code fragment
 * retrieves the current header, removes it, and adds a new one. Then
 * it retrieves the current body, removes it, and adds a new one.
 *
 * <pre>{@code
 *     SOAPPart sp = message.getSOAPPart();
 *     SOAPEnvelope se = sp.getEnvelope();
 *     se.getHeader().detachNode();
 *     SOAPHeader sh = se.addHeader();
 *     se.getBody().detachNode();
 *     SOAPBody sb = se.addBody();
 * }</pre>
 * It is an error to add a {@code SOAPBody} or {@code SOAPHeader}
 * object if one already exists.
 * <P>
 * The {@code SOAPEnvelope} interface provides three methods for creating
 * {@code Name} objects. One method creates {@code Name} objects with
 * a local name, a namespace prefix, and a namesapce URI. The second method creates
 * {@code Name} objects with a local name and a namespace prefix, and the third
 * creates {@code Name} objects with just a local name.  The following line of
 * code, in which <i>se</i> is a {@code SOAPEnvelope} object, creates a new
 * {@code Name} object with all three.
 * <pre>{@code
 *     Name name = se.createName("GetLastTradePrice", "WOMBAT",
 *                                "http://www.wombat.org/trader");
 * }</pre>
 *
 * @since 1.6
 */
public interface SOAPEnvelope extends SOAPElement {

    /**
     * Creates a new {@code Name} object initialized with the
     * given local name, namespace prefix, and namespace URI.
     * <P>
     * This factory method creates {@code Name} objects for use in
     * the SOAP/XML document.
     *
     * @param localName a {@code String} giving the local name
     * @param prefix a {@code String} giving the prefix of the namespace
     * @param uri a {@code String} giving the URI of the namespace
     * @return a {@code Name} object initialized with the given
     *         local name, namespace prefix, and namespace URI
     * @throws SOAPException if there is a SOAP error
     */
    public abstract Name createName(String localName, String prefix,
                                    String uri)
        throws SOAPException;

    /**
     * Creates a new {@code Name} object initialized with the
     * given local name.
     * <P>
     * This factory method creates {@code Name} objects for use in
     * the SOAP/XML document.
     *
     * @param localName a {@code String} giving the local name
     * @return a {@code Name} object initialized with the given
     *         local name
     * @throws SOAPException if there is a SOAP error
     */
    public abstract Name createName(String localName)
        throws SOAPException;

    /**
     * Returns the {@code SOAPHeader} object for
     * this {@code SOAPEnvelope} object.
     * <P>
     * A new {@code SOAPMessage} object is by default created with a
     * {@code SOAPEnvelope} object that contains an empty
     * {@code SOAPHeader} object.  As a result, the method
     * {@code getHeader} will always return a {@code SOAPHeader}
     * object unless the header has been removed and a new one has not
     * been added.
     *
     * @return the {@code SOAPHeader} object or {@code null} if
     *         there is none
     * @exception SOAPException if there is a problem obtaining the
     *            {@code SOAPHeader} object
     */
    public SOAPHeader getHeader() throws SOAPException;

    /**
     * Returns the {@code SOAPBody} object associated with this
     * {@code SOAPEnvelope} object.
     * <P>
     * A new {@code SOAPMessage} object is by default created with a
     * {@code SOAPEnvelope} object that contains an empty
     * {@code SOAPBody} object.  As a result, the method
     * {@code getBody} will always return a {@code SOAPBody}
     * object unless the body has been removed and a new one has not
     * been added.
     *
     * @return the {@code SOAPBody} object for this
     *         {@code SOAPEnvelope} object or {@code null}
     *         if there is none
     * @exception SOAPException if there is a problem obtaining the
     *            {@code SOAPBody} object
     */
    public SOAPBody getBody() throws SOAPException;
    /**
     * Creates a {@code SOAPHeader} object and sets it as the
     * {@code SOAPHeader} object for this {@code SOAPEnvelope}
     * object.
     * <P>
     * It is illegal to add a header when the envelope already
     * contains a header.  Therefore, this method should be called
     * only after the existing header has been removed.
     *
     * @return the new {@code SOAPHeader} object
     *
     * @exception SOAPException if this
     *            {@code SOAPEnvelope} object already contains a
     *            valid {@code SOAPHeader} object
     */
    public SOAPHeader addHeader() throws SOAPException;
    /**
     * Creates a {@code SOAPBody} object and sets it as the
     * {@code SOAPBody} object for this {@code SOAPEnvelope}
     * object.
     * <P>
     * It is illegal to add a body when the envelope already
     * contains a body. Therefore, this method should be called
     * only after the existing body has been removed.
     *
     * @return the new {@code SOAPBody} object
     *
     * @exception SOAPException if this
     *            {@code SOAPEnvelope} object already contains a
     *            valid {@code SOAPBody} object
     */
    public SOAPBody addBody() throws SOAPException;
}
