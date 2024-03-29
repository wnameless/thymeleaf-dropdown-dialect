/*
 *
 * Copyright 2019 Wei-Ming Wu
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

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

  @Bean
  public Bootstrap3DropdownDialect bootstrap3DropdownDialect() {
    return new Bootstrap3DropdownDialect();
  }

  @Bean
  public Bootstrap4DropdownDialect bootstrap4DropdownDialect() {
    return new Bootstrap4DropdownDialect();
  }

  @Bean
  public Bootstrap5DropdownDialect bootstrap5DropdownDialect() {
    return new Bootstrap5DropdownDialect();
  }

}
