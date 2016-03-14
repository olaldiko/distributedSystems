// **********************************************************************
//
// Copyright (c) 2003-2015 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************
//
// Ice version 3.6.1
//
// <auto-generated>
//
// Generated from file `CalculatorManager.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package utils;

public final class CalculatorManagerHolder extends Ice.ObjectHolderBase<CalculatorManager>
{
    public
    CalculatorManagerHolder()
    {
    }

    public
    CalculatorManagerHolder(CalculatorManager value)
    {
        this.value = value;
    }

    public void
    patch(Ice.Object v)
    {
        if(v == null || v instanceof CalculatorManager)
        {
            value = (CalculatorManager)v;
        }
        else
        {
            IceInternal.Ex.throwUOE(type(), v);
        }
    }

    public String
    type()
    {
        return _CalculatorManagerDisp.ice_staticId();
    }
}
