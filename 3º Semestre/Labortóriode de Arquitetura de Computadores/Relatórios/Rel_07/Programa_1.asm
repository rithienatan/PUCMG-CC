.text
.globl main
main:
addi $16, $0, 0x00000002 # a = 2
addi $17, $0, 0x00000003 # b = 3
addi $18, $0, 0x00000004 # c = 4
addi $19, $0, 0x00000005 # d = 5
add $8, $16, $17 # t0 = a + b
add $9, $18, $19 # t1 = c + d
sub $20, $8, $9 # x = t0 - t1
sub $10, $16, $17 # t2 = a - b
add $21, $10, $20 # y = t2 + x
sub $17, $20, $21 # b = x - y