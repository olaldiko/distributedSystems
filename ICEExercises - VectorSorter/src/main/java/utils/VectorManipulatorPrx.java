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

public interface VectorManipulatorPrx extends Ice.ObjectPrx
{
    void sort(int[] inVector, IntVectorHolder outVector);

    void sort(int[] inVector, IntVectorHolder outVector, java.util.Map<String, String> __ctx);

    Ice.AsyncResult begin_sort(int[] inVector);

    Ice.AsyncResult begin_sort(int[] inVector, java.util.Map<String, String> __ctx);

    Ice.AsyncResult begin_sort(int[] inVector, Ice.Callback __cb);

    Ice.AsyncResult begin_sort(int[] inVector, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    Ice.AsyncResult begin_sort(int[] inVector, Callback_VectorManipulator_sort __cb);

    Ice.AsyncResult begin_sort(int[] inVector, java.util.Map<String, String> __ctx, Callback_VectorManipulator_sort __cb);

    Ice.AsyncResult begin_sort(int[] inVector,
                               IceInternal.Functional_GenericCallback1<int[]> __responseCb,
                               IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb);

    Ice.AsyncResult begin_sort(int[] inVector,
                               IceInternal.Functional_GenericCallback1<int[]> __responseCb,
                               IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb,
                               IceInternal.Functional_BoolCallback __sentCb);

    Ice.AsyncResult begin_sort(int[] inVector,
                               java.util.Map<String, String> __ctx,
                               IceInternal.Functional_GenericCallback1<int[]> __responseCb,
                               IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb);

    Ice.AsyncResult begin_sort(int[] inVector,
                               java.util.Map<String, String> __ctx,
                               IceInternal.Functional_GenericCallback1<int[]> __responseCb,
                               IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb,
                               IceInternal.Functional_BoolCallback __sentCb);

    void end_sort(IntVectorHolder outVector, Ice.AsyncResult __result);

    void copyWithoutDuplicates(int[] inVector, IntVectorHolder outVector);

    void copyWithoutDuplicates(int[] inVector, IntVectorHolder outVector, java.util.Map<String, String> __ctx);

    Ice.AsyncResult begin_copyWithoutDuplicates(int[] inVector);

    Ice.AsyncResult begin_copyWithoutDuplicates(int[] inVector, java.util.Map<String, String> __ctx);

    Ice.AsyncResult begin_copyWithoutDuplicates(int[] inVector, Ice.Callback __cb);

    Ice.AsyncResult begin_copyWithoutDuplicates(int[] inVector, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    Ice.AsyncResult begin_copyWithoutDuplicates(int[] inVector, Callback_VectorManipulator_copyWithoutDuplicates __cb);

    Ice.AsyncResult begin_copyWithoutDuplicates(int[] inVector, java.util.Map<String, String> __ctx, Callback_VectorManipulator_copyWithoutDuplicates __cb);

    Ice.AsyncResult begin_copyWithoutDuplicates(int[] inVector,
                                                IceInternal.Functional_GenericCallback1<int[]> __responseCb,
                                                IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb);

    Ice.AsyncResult begin_copyWithoutDuplicates(int[] inVector,
                                                IceInternal.Functional_GenericCallback1<int[]> __responseCb,
                                                IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb,
                                                IceInternal.Functional_BoolCallback __sentCb);

    Ice.AsyncResult begin_copyWithoutDuplicates(int[] inVector,
                                                java.util.Map<String, String> __ctx,
                                                IceInternal.Functional_GenericCallback1<int[]> __responseCb,
                                                IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb);

    Ice.AsyncResult begin_copyWithoutDuplicates(int[] inVector,
                                                java.util.Map<String, String> __ctx,
                                                IceInternal.Functional_GenericCallback1<int[]> __responseCb,
                                                IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb,
                                                IceInternal.Functional_BoolCallback __sentCb);

    void end_copyWithoutDuplicates(IntVectorHolder outVector, Ice.AsyncResult __result);
}
