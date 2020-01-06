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

import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.engine.AttributeName;
import org.thymeleaf.model.IAttribute;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.processor.element.AbstractAttributeTagProcessor;
import org.thymeleaf.processor.element.IElementTagStructureHandler;
import org.thymeleaf.templatemode.TemplateMode;

public class DropdownItemProcessor extends AbstractAttributeTagProcessor {

  public DropdownItemProcessor(String dialectPrefix,
      boolean prefixAttributeName) {
    super(TemplateMode.HTML, dialectPrefix, "a", false, "dropdown-item",
        prefixAttributeName, 1000, true);
  }

  @Override
  protected void doProcess(ITemplateContext context, IProcessableElementTag tag,
      AttributeName attributeName, String attributeValue,
      IElementTagStructureHandler structureHandler) {
    IAttribute classAttr = tag.getAttribute("class");
    String classValue =
        classAttr == null ? "" : tag.getAttribute("class").getValue();
    if (classValue == null) classValue = "";
    structureHandler.setAttribute("class", classValue + " " + "dropdown-item");
  }

}
