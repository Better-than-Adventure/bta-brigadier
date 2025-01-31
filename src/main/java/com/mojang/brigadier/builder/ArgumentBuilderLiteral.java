// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT license.

package com.mojang.brigadier.builder;

import com.mojang.brigadier.tree.CommandNode;
import com.mojang.brigadier.tree.LiteralCommandNode;

public class ArgumentBuilderLiteral<S> extends ArgumentBuilder<S, ArgumentBuilderLiteral<S>> {
    private final String literal;

    protected ArgumentBuilderLiteral(final String literal) {
        this.literal = literal;
    }

    public static <S> ArgumentBuilderLiteral<S> literal(final String name) {
        return new ArgumentBuilderLiteral<>(name);
    }

    @Override
    protected ArgumentBuilderLiteral<S> getThis() {
        return this;
    }

    public String getLiteral() {
        return literal;
    }

    @Override
    public LiteralCommandNode<S> build() {
        final LiteralCommandNode<S> result = new LiteralCommandNode<>(getLiteral(), getCommand(), getRequirement(), getRedirect(), getRedirectModifier(), isFork());

        for (final CommandNode<S> argument : getArguments()) {
            result.addChild(argument);
        }

        return result;
    }
}
