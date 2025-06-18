package org.acme.foobar;

public record Foo(String name, String description) {

    public Foo(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
