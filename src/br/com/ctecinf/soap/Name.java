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
 * A representation of an XML name.  This interface provides methods for
 * getting the local and namespace-qualified names and also for getting the
 * prefix associated with the namespace for the name. It is also possible
 * to get the URI of the namespace.
 * <P>
 * The following is an example of a namespace declaration in an element.
 * {@code <wombat:GetLastTradePrice xmlns:wombat="http://www.wombat.org/trader">}
 * ("xmlns" stands for "XML namespace".)
 * The following
 * shows what the methods in the {@code Name} interface will return.
 * <UL>
 *  <LI>{@code getQualifiedName} will return "prefix:LocalName" =
 *      "WOMBAT:GetLastTradePrice"
 *  <LI>{@code getURI} will return "http://www.wombat.org/trader"
 *  <LI>{@code getLocalName} will return "GetLastTracePrice"
 *  <LI>{@code getPrefix} will return "WOMBAT"
 * </UL>
 * <P>
 * XML namespaces are used to disambiguate SOAP identifiers from
 * application-specific identifiers.
 * <P>
 * {@code Name} objects are created using the method
 * {@code SOAPEnvelope.createName}, which has two versions.
 * One method creates {@code Name} objects with
 * a local name, a namespace prefix, and a namespace URI.
 *  and the second creates {@code Name} objects with just a local name.
 * The following line of
 * code, in which <i>se</i> is a {@code SOAPEnvelope} object, creates a new
 * {@code Name} object with all three.
 * <pre>{@code
 *     Name name = se.createName("GetLastTradePrice", "WOMBAT",
 *                                "http://www.wombat.org/trader");
 * }</pre>
 * The following line of code gives an example of how a {@code Name} object
 * can be used. The variable <i>element</i> is a {@code SOAPElement} object.
 * This code creates a new {@code SOAPElement} object with the given name and
 * adds it to <i>element</i>.
 * <pre>{@code
 *     element.addChildElement(name);
 * }</pre>
 * <P>
 * The {@code Name} interface may be deprecated in a future release of SAAJ
 * in favor of {@code javax.xml.namespace.QName}
 * @see SOAPEnvelope#createName(String, String, String) SOAPEnvelope.createName
 * @see SOAPFactory#createName(String, String, String) SOAPFactory.createName
 * @since 1.6
 */
public interface Name {
    /**
     * Gets the local name part of the XML name that this {@code Name}
     * object represents.
     *
     * @return a string giving the local name
     */
    String getLocalName();

    /**
     * Gets the namespace-qualified name of the XML name that this
     * {@code Name} object represents.
     *
     * @return the namespace-qualified name as a string
     */
    String getQualifiedName();

    /**
     * Returns the prefix that was specified when this {@code Name} object
     * was initialized. This prefix is associated with the namespace for the XML
     * name that this {@code Name} object represents.
     *
     * @return the prefix as a string
     */
    String getPrefix();

    /**
     * Returns the URI of the namespace for the XML
     * name that this {@code Name} object represents.
     *
     * @return the URI as a string
     */
    String getURI();
}
