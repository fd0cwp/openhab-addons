/*
 * Copyright (c) 2010-2025 Contributors to the openHAB project
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.openhab.binding.mielecloud.internal.webservice.api.json;

import java.util.Objects;
import java.util.Optional;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

/**
 * Immutable POJO representing the current spinning speed, queried from the Miele REST API.
 *
 * @author Björn Lange - Initial contribution
 */
@NonNullByDefault
public class SpinningSpeed {
    @SerializedName("value_raw")
    @Nullable
    private Integer valueRaw;
    @SerializedName("value_localized")
    @Nullable
    private String valueLocalized;
    @SerializedName("unit")
    @Nullable
    private String unit;

    public Optional<Integer> getValueRaw() {
        return Optional.ofNullable(valueRaw);
    }

    public Optional<String> getValueLocalized() {
        return Optional.ofNullable(valueLocalized);
    }

    public Optional<String> getUnit() {
        return Optional.ofNullable(unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(unit, valueLocalized, valueRaw);
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        SpinningSpeed other = (SpinningSpeed) obj;
        return Objects.equals(unit, other.unit) && Objects.equals(valueLocalized, other.valueLocalized)
                && Objects.equals(valueRaw, other.valueRaw);
    }

    @Override
    public String toString() {
        return "SpinningSpeed [valueRaw=" + valueRaw + ", valueLocalized=" + valueLocalized + ", unit=" + unit + "]";
    }
}
