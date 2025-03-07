package net.minecraft.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import pl.moresteck.uberbukkit.Uberbukkit;

public class Packet5EntityEquipment extends Packet {

    public int a;
    public int b;
    public int c;
    public int d;

    public Packet5EntityEquipment() {}

    public Packet5EntityEquipment(int i, int j, ItemStack itemstack) {
        this.a = i;
        this.b = j;
        if (itemstack == null) {
            this.c = -1;
            this.d = 0;
        } else {
            this.c = itemstack.id;
            this.d = itemstack.getData();
        }
    }

    public void a(DataInputStream datainputstream) throws IOException {
        this.a = datainputstream.readInt();
        this.b = datainputstream.readShort();
        this.c = datainputstream.readShort();
        // uberbukkit
        if (Uberbukkit.getPVN() >= 8) {
            this.d = datainputstream.readShort();
        } else {
            this.d = 0;
        }
    }

    public void a(DataOutputStream dataoutputstream) throws IOException {
        dataoutputstream.writeInt(this.a);
        dataoutputstream.writeShort(this.b);
        dataoutputstream.writeShort(this.c);
        // uberbukkit
        if (Uberbukkit.getPVN() >= 8) {
            dataoutputstream.writeShort(this.d);
        }
    }

    public void a(NetHandler nethandler) {
        nethandler.a(this);
    }

    public int a() {
        return 8;
    }
}
