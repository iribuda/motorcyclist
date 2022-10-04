package com.company.shopping;

import com.company.clothes.Ammunition;
import com.company.clothes.Jacket;

public class AmmunitionIsJacket implements AmmunitionFilter{
    @Override
    public boolean check(Ammunition ammunition) {
        return ammunition instanceof Jacket;
    }
}
