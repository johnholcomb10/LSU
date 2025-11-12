int prog2(int i, int j, int *k, int *l, int a[6]) 
{
    int return_value = i - j + 3;
    *k = 10 * *k;
    *l = a[0] + a[1] + a[2] + a[3] + a[4];

    return return_value;
}