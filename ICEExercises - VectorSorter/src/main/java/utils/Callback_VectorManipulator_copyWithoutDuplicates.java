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
// Generated from file `VectorSorter.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package utils;

abstract class Callback_VectorManipulator_copyWithoutDuplicates
    extends IceInternal.TwowayCallback implements Ice.TwowayCallbackArg1<int[]>
{
    public final void __completed(Ice.AsyncResult __result)
    {
        VectorManipulatorPrxHelper.__copyWithoutDuplicates_completed(this, __result);
    }
}
