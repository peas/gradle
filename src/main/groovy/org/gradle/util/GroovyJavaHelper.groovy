/*
 * Copyright 2007-2008 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
 
package org.gradle.util

import org.gradle.api.TaskAction

/**
 * @author Hans Dockter
 */
class GroovyJavaHelper {
    static TaskAction closureToAction(Closure closure) {
        closure as TaskAction
    }

    static Closure createNoArgsClosure(Object returnValue) {
        {->  returnValue }
    }

    static Closure createConventionClosure(Object returnValue) {
        {Convention ->  returnValue }
    }

    static Closure createExecuteClosure(Object executable) {
        { -> executable.execute() }
    }
}