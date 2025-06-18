package org.acme.foobar;

import java.util.List;

public record Bar(List<Foo> fooList) {
    public Bar(List<Foo> fooList) {
        this.fooList = fooList;
    }
}
