/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.lxyscls.jvmjava.runtimedata.heap.classfile;

import com.github.lxyscls.jvmjava.classfile.MemberInfo;
import com.github.lxyscls.jvmjava.classfile.attribute.ConstantValueAttributeInfo;
import java.io.IOException;

/**
 *
 * @author sk-xinyilong
 */
public class Field extends ClassMember {
    private int slotId;
    private final int constantValueIndex;
    
    public Field(Jclass cls, MemberInfo info) {
        super(cls, info);
        ConstantValueAttributeInfo constantInfo = info.getConstantValueAttribute();
        if (constantInfo != null) {
            constantValueIndex = constantInfo.getConstantValueIndex();
        } else {
            constantValueIndex = 0;
        }
    }
    
    public int getSlotId() {
        return slotId;
    }
    
    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }
    
    public int getConstantValueIndex() {
        return this.constantValueIndex;
    }
    
    public boolean isLongOrDouble() {
        return descriptor.equals("J") || descriptor.equals("D");
    }
    
    public Jclass getTypeClass() throws IOException {
        String className = Jclass.toClassName(descriptor);
        return getBelongClass().getClassLoader().loadClass(className);
    }
}
