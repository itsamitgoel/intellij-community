/*
 * Copyright 2000-2009 JetBrains s.r.o.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.intellij.psi.impl.include;

import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFileSystemItem;
import org.jetbrains.annotations.Nullable;

/**
 * @author Dmitry Avdeev
 */
public abstract class FileIncludeManager {

  public static FileIncludeManager getManager(Project project) {
    return ServiceManager.getService(project, FileIncludeManager.class);
  }

  public abstract VirtualFile[] getIncludedFiles(VirtualFile file, boolean compileTimeOnly);

  public abstract VirtualFile[] getIncludingFiles(VirtualFile file, boolean compileTimeOnly);

  @Nullable
  public abstract PsiFileSystemItem resolveFileReference(String text, VirtualFile context);
}
