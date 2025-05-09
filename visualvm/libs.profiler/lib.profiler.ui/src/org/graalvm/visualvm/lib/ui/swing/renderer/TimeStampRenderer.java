/*
 * Copyright (c) 1997, 2022, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

package org.graalvm.visualvm.lib.ui.swing.renderer;

import org.graalvm.visualvm.lib.ui.Formatters;

import javax.swing.*;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Optional;

public class TimeStampRenderer extends FormattedLabelRenderer implements RelativeRenderer {

    protected boolean renderingDiff;

    public TimeStampRenderer() {
        super(Formatters.timestampFormat());
        setHorizontalAlignment(SwingConstants.TRAILING);
    }

    @Override
    public void setDiffMode(boolean diffMode) {
        renderingDiff = diffMode;
    }

    @Override
    public boolean isDiffMode() {
        return renderingDiff;
    }

    public void setValue(Object value, int row) {
        if (value instanceof Long) {
            String s = Instant.ofEpochMilli((Long) value).atZone(ZoneId.systemDefault()).toLocalDateTime().toString();
            super.setValue(s, row);
            return;
        }
        super.setValue("", row);
    }

}
