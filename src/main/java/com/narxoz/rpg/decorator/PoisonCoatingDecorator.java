package com.narxoz.rpg.decorator;

public class PoisonCoatingDecorator extends ActionDecorator {
    public PoisonCoatingDecorator(AttackAction wrapped) { super(wrapped); }
    @Override public String getActionName() { return "Venomous " + super.getActionName(); }
    @Override public int getDamage() { return super.getDamage() + 5; }
    @Override public String getEffectSummary() { return super.getEffectSummary() + " + PoisonDot"; }
}