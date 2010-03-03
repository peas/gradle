/*
 * Copyright 2010 the original author or authors.
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

package org.gradle.api.internal.project;

import org.gradle.api.GradleException;

public class ProjectState {
    private boolean executing;
    private boolean executed;
    private Throwable failure;

    public boolean getExecuted() {
        return executed;
    }

    public void executed() {
        executed = true;
    }

    public void executed(Throwable failure) {
        assert this.failure == null;
        this.failure = failure;
        executed = true;
    }

    public boolean getExecuting() {
        return executing;
    }

    public void setExecuting(boolean executing) {
        this.executing = executing;
    }

    public Throwable getFailure() {
        return failure;
    }

    public void rethrowFailure() {
        if (failure == null) {
            return;
        }
        if (failure instanceof RuntimeException) {
            throw (RuntimeException) failure;
        }
        throw new GradleException(failure);
    }
}