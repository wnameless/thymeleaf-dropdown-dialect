/*
 *
 * Copyright 2020 Wei-Ming Wu
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 *
 */
package com.github.wnameless.thymeleaf.ext;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.thymeleaf.model.ICDATASection;
import org.thymeleaf.model.ICloseElementTag;
import org.thymeleaf.model.IComment;
import org.thymeleaf.model.IDocType;
import org.thymeleaf.model.IModel;
import org.thymeleaf.model.IModelVisitor;
import org.thymeleaf.model.IOpenElementTag;
import org.thymeleaf.model.IProcessingInstruction;
import org.thymeleaf.model.IStandaloneElementTag;
import org.thymeleaf.model.ITemplateEnd;
import org.thymeleaf.model.ITemplateEvent;
import org.thymeleaf.model.ITemplateStart;
import org.thymeleaf.model.IText;
import org.thymeleaf.model.IXMLDeclaration;

public final class ThymeleafDialectUtils {

  private ThymeleafDialectUtils() {}

  public static Map<String, String> mergeAttributeValue(
      Map<String, String> attrbuteMap, String attributeName,
      String attributeValue) {
    if (attrbuteMap.containsKey(attributeName)) {
      attrbuteMap.put(attributeName,
          attrbuteMap.get(attributeName) + " " + attributeValue);
    } else {
      attrbuteMap.put(attributeName, attributeValue);
    }

    return attrbuteMap;
  }

  public static Map<String, String> getAttributeMap(ITemplateEvent event) {
    final Map<String, String> attr = new LinkedHashMap<>();

    event.accept(new IModelVisitor() {

      @Override
      public void visit(ITemplateStart templateStart) {}

      @Override
      public void visit(ITemplateEnd templateEnd) {}

      @Override
      public void visit(IXMLDeclaration xmlDeclaration) {}

      @Override
      public void visit(IDocType docType) {}

      @Override
      public void visit(ICDATASection cdataSection) {}

      @Override
      public void visit(IComment comment) {}

      @Override
      public void visit(IText text) {}

      @Override
      public void visit(IStandaloneElementTag standaloneElementTag) {
        attr.putAll(standaloneElementTag.getAttributeMap());
      }

      @Override
      public void visit(IOpenElementTag openElementTag) {
        attr.putAll(openElementTag.getAttributeMap());
      }

      @Override
      public void visit(ICloseElementTag closeElementTag) {}

      @Override
      public void visit(IProcessingInstruction processingInstruction) {}

    });

    return attr;
  }

  public static List<ITemplateEvent> getEvents(IModel model) {
    List<ITemplateEvent> events = new ArrayList<>();

    for (int i = 1; i < model.size() - 1; i++) {
      events.add(model.get(i));
    }

    return events;
  }

}
