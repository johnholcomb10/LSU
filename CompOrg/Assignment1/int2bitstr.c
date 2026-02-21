#include <stdio.h>

unsigned f2u(float f) {

    union {
        float f;
        unsigned u;
    } temp;
    temp.f = f;
    return temp.u;

}

char int2bitstr(int I, char *str) {

    // Go through each bit
    for (int j = 0; j < 32; j++) {
        // Use right shift and bitwise AND to get each bit.
        str[j] = (I >> (31 - j)) & 1 ? '1' : '0';
    }
  
    // Terminate the string
    str[32] = '\0';
  
    // XOR the most and second most significant byte
    return (I >> 24) ^ (I >> 16);

}

int get_exp_value(float f) {

    // Convert float to unsigned int
    unsigned u = f2u(f);
    
    // Get exponent bits through right shifting, use AND to eliminate exponent bit
    unsigned exp_bits = (u >> 23) & 0xFF;
    
    // Check for special values (all exponent bits are 1 or 0)
    if (exp_bits == 0xFF) {
        return -128;
    } else if (exp_bits == 0x00) {
        return 0;
    }
    
    // Subtract bias to get exponent
    return exp_bits - 127;
    
}
