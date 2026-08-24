package za.ac.cput.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
class InvalidInputExceptionTest { @Test void messageIsStored(){assertEquals("bad",new InvalidInputException("bad").getMessage());} }
