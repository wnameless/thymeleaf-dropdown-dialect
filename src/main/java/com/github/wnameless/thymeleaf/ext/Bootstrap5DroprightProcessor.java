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

import java.util.LinkedHashMap;
import java.util.Map;

import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.model.AttributeValueQuotes;
import org.thymeleaf.model.IModel;
import org.thymeleaf.model.IModelFactory;
import org.thymeleaf.model.IOpenElementTag;
import org.thymeleaf.processor.element.AbstractElementModelProcessor;
import org.thymeleaf.processor.element.IElementModelStructureHandler;
import org.thymeleaf.templatemode.TemplateMode;

public class Bootstrap5DroprightProcessor
    extends AbstractElementModelProcessor {

  public Bootstrap5DroprightProcessor(String dialectPrefix,
      boolean prefixElementName) {
    super(TemplateMode.HTML, dialectPrefix, "dropright", prefixElementName,
        null, false, 1000);
  }

  @Override
  protected void doProcess(ITemplateContext context, IModel model,
      IElementModelStructureHandler structureHandler) {
    IModelFactory modelFactory = context.getModelFactory();

    Map<String, String> originAttr =
        ThymeleafDialectUtils.getAttributeMap(model.get(0));
    String bsText = originAttr.get("bs:text");
    originAttr.remove("bs:text");
    String bsIcon = originAttr.get("bs:icon");
    originAttr.remove("bs:icon");
    String bsIconAppend = originAttr.get("bs:icon-append");
    originAttr.remove("bs:icon-append");

    Map<String, String> attr = new LinkedHashMap<>();
    String id;
    attr.put("type", "button");
    attr.put("data-bs-toggle", "dropdown");
    attr.put("aria-expanded", "false");
    attr.put("id", "dropdownMenu");

    attr.putAll(originAttr);
    ThymeleafDialectUtils.mergeAttributeValue(attr, "class",
        "btn btn-default dropdown-toggle");
    id = attr.get("id");

    model.replace(0,
        modelFactory.createOpenElementTag("div", "class", "dropend"));

    int idx = 1;
    model.insert(idx++, modelFactory.createOpenElementTag("button", attr,
        AttributeValueQuotes.DOUBLE, false));

    if (bsIcon != null) {
      model.insert(idx++, modelFactory.createStandaloneElementTag("span",
          "class", bsIcon, false, false));
    }

    if (bsText != null) {
      model.insert(idx++, modelFactory.createText(bsText));
    }

    if (bsIconAppend != null) {
      model.insert(idx++, modelFactory.createStandaloneElementTag("span",
          "class", bsIconAppend, false, false));
    }

    if (bsIcon == null && bsText == null && bsIconAppend == null) {
      attr = new LinkedHashMap<>();
      attr.put("width", "16");
      attr.put("height", "16");
      attr.put("src", Base64Icon.barsIcon);
      model.insert(idx++, modelFactory.createStandaloneElementTag("img", attr,
          AttributeValueQuotes.DOUBLE, false, true));
    }

    model.insert(idx++, modelFactory.createCloseElementTag("button"));

    attr = new LinkedHashMap<>();
    attr.put("class", "dropdown-menu");
    attr.put("aria-labelledby", id);
    model.insert(idx++, modelFactory.createOpenElementTag("div", attr,
        AttributeValueQuotes.DOUBLE, false));

    model.insert(model.size() - 1, modelFactory.createCloseElementTag("div"));
    model.replace(model.size() - 1, modelFactory.createCloseElementTag("div"));

    for (int i = 1; i < model.size() - 1; i++) {
      if (model.get(i) instanceof IOpenElementTag) {
        IOpenElementTag openTag = (IOpenElementTag) model.get(i);
        if (openTag.getElementCompleteName().equals("a")) {
          model.replace(i,
              modelFactory.createOpenElementTag("a",
                  ThymeleafDialectUtils.mergeAttributeValue(
                      openTag.getAttributeMap(), "class", "dropdown-item"),
                  AttributeValueQuotes.DOUBLE, false));
        }
      }
    }
  }

}
