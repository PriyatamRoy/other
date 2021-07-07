package org.example.models;

import org.example.exceptions.SlotNotFoundException;
import org.example.exceptions.VehicleTypeMismatchException;

public abstract class ParkingLot {
    private String type;
    private int capacity;
    private Vehicle [] slots;

    public ParkingLot(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.slots = new Vehicle[capacity];
    }

    public String getType() {
        return this.type;
    }
    public int getCapacity() {
        return this.capacity;
    }

    protected boolean isValidSlot(int slot) {
        return slot >= 0 && slot < capacity;
    }

    protected Vehicle[] getSlots() {
        return slots;
    }

    protected synchronized boolean park(int slot, Vehicle vehicle) throws SlotNotFoundException {
        if(!isValidSlot(slot)) {
            throw new SlotNotFoundException("Slot " + slot + " not found");
        }
        if(slots[slot] == null) {
            slots[slot] = vehicle;
            return true;
        } else {
            return false;
        }
    }

    public void leave(int slot) throws SlotNotFoundException {
        if(!isValidSlot(slot)) {
            throw new SlotNotFoundException("Slot " + slot + " not found");
        }
        slots[slot] = null;
    }

    public abstract int park(Vehicle vehicle) throws VehicleTypeMismatchException;
}
