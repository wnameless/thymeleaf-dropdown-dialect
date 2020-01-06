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
import org.thymeleaf.processor.element.AbstractElementModelProcessor;
import org.thymeleaf.processor.element.IElementModelStructureHandler;
import org.thymeleaf.templatemode.TemplateMode;

public class Bootstrap4DropdownProcessor extends AbstractElementModelProcessor {

  public Bootstrap4DropdownProcessor(String dialectPrefix,
      boolean prefixElementName) {
    super(TemplateMode.HTML, dialectPrefix, "dropdown", prefixElementName, null,
        false, 1000);
  }

  @Override
  protected void doProcess(ITemplateContext context, IModel model,
      IElementModelStructureHandler structureHandler) {
    IModelFactory modelFactory = context.getModelFactory();

    Map<String, String> originAttr =
        ThymeleafDialectUtils.getAttributeMap(model.get(0));
    boolean bsDropup = originAttr.containsKey("bs:dropup");
    originAttr.remove("bs:dropup");
    boolean bsDropright = originAttr.containsKey("bs:dropright");
    originAttr.remove("bs:dropright");
    boolean bsDropleft = originAttr.containsKey("bs:dropleft");
    originAttr.remove("bs:dropleft");
    String bsText = originAttr.get("bs:text");
    originAttr.remove("bs:text");
    String bsIcon = originAttr.get("bs:icon");
    originAttr.remove("bs:icon");

    Map<String, String> attr = new LinkedHashMap<>();
    String id;
    attr.put("type", "button");
    attr.put("data-toggle", "dropdown");
    attr.put("aria-haspopup", "true");
    attr.put("aria-expanded", "true");
    attr.put("id", "dropdownMenu");

    attr.putAll(originAttr);
    if (attr.containsKey("class")) {
      attr.put("class",
          "btn btn-default dropdown-toggle" + " " + attr.get("class"));
    } else {
      attr.put("class", "btn btn-default dropdown-toggle");
    }
    id = attr.get("id");

    String divClass = "dropdown";
    if (bsDropup) divClass = "dropup";
    if (bsDropright) divClass = "dropright";
    if (bsDropleft) divClass = "dropleft";
    model.replace(0,
        modelFactory.createOpenElementTag("div", "class", divClass));

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

    if (bsIcon == null && bsText == null) {
      attr = new LinkedHashMap<>();
      attr.put("width", "16");
      attr.put("height", "16");
      attr.put("src",
          "data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIyNCIgaGVpZ2h0PSIyNCIgdmlld0JveD0iMCAwIDI0IDI0Ij48cGF0aCBkPSJNMjQgMTMuNjE2di0zLjIzMmMtMS42NTEtLjU4Ny0yLjY5NC0uNzUyLTMuMjE5LTIuMDE5di0uMDAxYy0uNTI3LTEuMjcxLjEtMi4xMzQuODQ3LTMuNzA3bC0yLjI4NS0yLjI4NWMtMS41NjEuNzQyLTIuNDMzIDEuMzc1LTMuNzA3Ljg0N2gtLjAwMWMtMS4yNjktLjUyNi0xLjQzNS0xLjU3Ni0yLjAxOS0zLjIxOWgtMy4yMzJjLS41ODIgMS42MzUtLjc0OSAyLjY5Mi0yLjAxOSAzLjIxOWgtLjAwMWMtMS4yNzEuNTI4LTIuMTMyLS4wOTgtMy43MDctLjg0N2wtMi4yODUgMi4yODVjLjc0NSAxLjU2OCAxLjM3NSAyLjQzNC44NDcgMy43MDctLjUyNyAxLjI3MS0xLjU4NCAxLjQzOC0zLjIxOSAyLjAydjMuMjMyYzEuNjMyLjU4IDIuNjkyLjc0OSAzLjIxOSAyLjAxOS41MyAxLjI4Mi0uMTE0IDIuMTY2LS44NDcgMy43MDdsMi4yODUgMi4yODZjMS41NjItLjc0MyAyLjQzNC0xLjM3NSAzLjcwNy0uODQ3aC4wMDFjMS4yNy41MjYgMS40MzYgMS41NzkgMi4wMTkgMy4yMTloMy4yMzJjLjU4Mi0xLjYzNi43NS0yLjY5IDIuMDI3LTMuMjIyaC4wMDFjMS4yNjItLjUyNCAyLjEyLjEwMSAzLjY5OC44NTFsMi4yODUtMi4yODZjLS43NDQtMS41NjMtMS4zNzUtMi40MzMtLjg0OC0zLjcwNi41MjctMS4yNzEgMS41ODgtMS40NCAzLjIyMS0yLjAyMXptLTEyIDIuMzg0Yy0yLjIwOSAwLTQtMS43OTEtNC00czEuNzkxLTQgNC00IDQgMS43OTEgNCA0LTEuNzkxIDQtNCA0eiIvPjwvc3ZnPg==");
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
  }

}
