/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE396_Catch_Generic_Exception__Exception_01.java
Label Definition File: CWE396_Catch_Generic_Exception.label.xml
Template File: point-flaw-01.tmpl.java
*/
/*
* @description
* CWE: 396 An overly broad catch statement may cause errors in program execution if unexpected exceptions are thrown
* Sinks: Exception
*    GoodSink: Catch specific exception type (NumberFormatException)
*    BadSink : Catch Exception, which is overly generic
* Flow Variant: 01 Baseline
*
* */

package testcases.CWE396_Catch_Generic_Exception;

import testcasesupport.*;

public class CWE396_Catch_Generic_Exception__Exception_01 extends AbstractTestCase
{

    public void bad() throws Throwable
    {

        try {
            Integer.parseInt("Test"); /* Will throw NumberFormatException */
        }
        catch (Exception e)     /* FLAW: Catch Exception, which is overly generic */
        {
            IO.writeLine("Caught Exception");
            throw e; /* Rethrow */
        }

    }

    public void good() throws Throwable
    {
        good1();
    }

    private void good1() throws Throwable
    {

        try {
            Integer.parseInt("Test"); /* Will throw NumberFormatException */
        }
        catch (NumberFormatException e)     /* FIX: Catch NumberFormatException */
        {
            IO.writeLine("Caught Exception");
            throw e; /* Rethrow */
        }

    }

    /* Below is the main(). It is only used when building this testcase on
       its own for testing or for building a binary to use in testing binary
       analysis tools. It is not used when compiling all the testcases as one
       application, which is how source code analysis tools are tested. */
    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }
}

