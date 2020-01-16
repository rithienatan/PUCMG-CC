# x = 100000
# y = 200000
# z = x + y
# x-$16, y-$17, z-$18
.text
.globl main
main: 
addi $8, $0, 1 # x = 100000
sll $8, $8, 16 # nop
ori $16, $8, 0x86A0 # y = 86A0