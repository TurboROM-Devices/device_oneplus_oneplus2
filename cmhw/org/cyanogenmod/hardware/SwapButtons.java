/*
 * Copyright (C) 2016 The CyanogenMod Project
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

package org.cyanogenmod.hardware;

import java.io.File;

import org.cyanogenmod.hardware.util.FileUtils;

/**
 * Swap buttons.
 */
public class SwapButtons {

    private static String CONTROL_PATH = "/proc/s1302/key_rep";

    public static boolean isSupported() {
        return new File(CONTROL_PATH).exists();
    }

    public static boolean isActive() {
        return FileUtils.readOneLine(CONTROL_PATH).equals("1");
    }

    public static boolean setActive(boolean state) {
        return FileUtils.writeLine(CONTROL_PATH, (state ? "1" : "0"));
    }

}
