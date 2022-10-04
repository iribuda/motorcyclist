package com.company.shopping;

import com.company.clothes.Ammunition;

@FunctionalInterface
public interface AmmunitionFilter {
    public boolean check(Ammunition ammunition);
}
