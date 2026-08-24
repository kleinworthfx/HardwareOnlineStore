package za.ac.cput.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
class ResourceNotFoundExceptionTest { @Test void messageIsStored(){assertEquals("missing",new ResourceNotFoundException("missing").getMessage());} }
