#include <stdio.h>
#include <assert.h>

/*
 * This program tests int2bitstr by printing out any 32-bit integer as a 
 * 32-length string of zeros and ones. The number is also printed in hex
 * with formatted binary for correctness checking.
 */

unsigned f2u(float f);

int main(void)
{
    char str[33], hex[5];
    char xor_result;
    int  i;
    char int2bitstr(int I, char *str);
    int get_exp_value(float f);

    hex[4] = '\0';
    do {
        int k;
        printf("\nEnter integer to convert to bits: ");
        assert(scanf("%d", &i) == 1);

        xor_result = int2bitstr(i, str);
        printf("%d : %s\n", i, str);
        printf("XOR result between MSB and Second MSB: %d\n", xor_result);

        printf("0x%x : ", i);
        for (k = 0; k < 32; k += 4) {
            char *sp = str + k;
            hex[0] = sp[0];
            hex[1] = sp[1];
            hex[2] = sp[2];
            hex[3] = sp[3];
            printf("%s ", hex);
        }
        printf("\n");

        float f = i;
        xor_result = int2bitstr(f2u(f), str);
        printf("%f : %s\n", f, str);
        printf("exp : %d\n", get_exp_value(f));

    } while (i);

    return 0;  
}
