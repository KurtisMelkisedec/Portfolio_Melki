package com.portoflio.back.data.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Statut {
    Deleted(0),
    Archive(1),
    Visible(2);

    private final Integer index;
}
