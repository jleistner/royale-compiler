/*
 *
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package org.apache.flex.compiler.internal.mxml.visitor;

import org.apache.flex.compiler.tree.as.IASNode;
import org.apache.flex.compiler.tree.mxml.IMXMLArrayNode;
import org.apache.flex.compiler.tree.mxml.IMXMLDeclarationsNode;
import org.apache.flex.compiler.tree.mxml.IMXMLDeferredInstanceNode;
import org.apache.flex.compiler.tree.mxml.IMXMLDocumentNode;
import org.apache.flex.compiler.tree.mxml.IMXMLInstanceNode;
import org.apache.flex.compiler.tree.mxml.IMXMLIntNode;
import org.apache.flex.compiler.tree.mxml.IMXMLLiteralNode;
import org.apache.flex.compiler.tree.mxml.IMXMLPropertySpecifierNode;
import org.apache.flex.compiler.tree.mxml.IMXMLStringNode;
import org.apache.flex.compiler.visitor.IASNodeStrategy;
import org.apache.flex.compiler.visitor.IMXMLBlockVisitor;

/**
 * @author Michael Schmalle
 * @author Erik de Bruin
 */
public class MXMLNodeSwitch implements IASNodeStrategy
{
    private final IMXMLBlockVisitor visitor;

    public MXMLNodeSwitch(IMXMLBlockVisitor visitor)
    {
        this.visitor = visitor;
    }

    @Override
    public void handle(IASNode node)
    {
        switch (node.getNodeID())
        {
        case MXMLArrayID:
            visitor.visitArray((IMXMLArrayNode) node);
            break;
        case MXMLDeclarationsID:
            visitor.visitDeclarations((IMXMLDeclarationsNode) node);
            break;
        case MXMLDeferredInstanceID:
            visitor.visitDeferredInstance((IMXMLDeferredInstanceNode) node);
            break;
        case MXMLDocumentID:
            visitor.visitDocument((IMXMLDocumentNode) node);
            break;
        case MXMLIntID:
            visitor.visitInt((IMXMLIntNode) node);
            break;
        case MXMLInstanceID:
            visitor.visitInstance((IMXMLInstanceNode) node);
            break;
        case MXMLLiteralID:
            visitor.visitLiteral((IMXMLLiteralNode) node);
            break;
        case MXMLPropertySpecifierID:
            visitor.visitPropertySpecifier((IMXMLPropertySpecifierNode) node);
            break;
        case MXMLStringID:
            visitor.visitString((IMXMLStringNode) node);
            break;

        case MXMLApplicationID:
        case MXMLBindingID:
        case MXMLBindingAttributeID:
        case MXMLBooleanID:
        case MXMLClassID:
        case MXMLClassDefinitionID:
        case MXMLClearID:
        case MXMLComponentID:
        case MXMLConcatenatedDataBindingID:
        case MXMLDataBindingID:
        case MXMLDateID:
        case MXMLDefinitionID:
        case MXMLDesignLayerID:
        case MXMLEmbedID:
        case MXMLEffectSpecifierID:
        case MXMLEventSpecifierID:
        case MXMLFactoryID:
        case MXMLFileID:
        case MXMLFunctionID:
        case MXMLHTTPServiceID:
        case MXMLHTTPServiceRequestID:
        case MXMLImplementsID:
        case MXMLLibraryID:
        case MXMLMetadataID:
        case MXMLModelID:
        case MXMLModelPropertyID:
        case MXMLModelRootID:
        case MXMLNumberID:
        case MXMLObjectID:
        case MXMLPrivateID:
        case MXMLRegExpID:
        case MXMLRemoteObjectID:
        case MXMLRemoteObjectMethodID:
        case MXMLReparentID:
        case MXMLRepeaterID:
        case MXMLResourceID:
        case MXMLScriptID:
        case MXMLStateID:
        case MXMLStyleID:
        case MXMLStyleSpecifierID:
        case MXMLUintID:
        case MXMLVectorID:
        case MXMLWebServiceID:
        case MXMLWebServiceOperationID:
        case MXMLXMLID:
        case MXMLXMLListID:
        default:
            throw new IllegalArgumentException(
                    "No handler specified for nodes of type '"
                            + node.getNodeID().getParaphrase() + "'");
        }
    }

}
