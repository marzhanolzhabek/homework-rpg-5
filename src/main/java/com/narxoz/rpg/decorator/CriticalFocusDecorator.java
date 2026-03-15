package com.narxoz.rpg.decorator;

public class CriticalFocusDecorator extends ActionDecorator {
    public CriticalFocusDecorator(AttackAction wrapped) { super(wrapped); }
    @Override public String getActionName() { return super.getActionName() + " (Focused)"; }
    @Override public int getDamage() { return (int)(super.getDamage() * 1.5); }
    @Override public String getEffectSummary() { return super.getEffectSummary() + " + CriticalStrike"; }
}