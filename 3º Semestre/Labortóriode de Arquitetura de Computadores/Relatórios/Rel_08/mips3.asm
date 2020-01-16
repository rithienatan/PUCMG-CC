# x mapeado em $s1
.text
.globl teste
teste:

addi $16, $zero, 1 # x=1

addi $8, $zero, 0x1001
sll $8, $8, 16 # valor do adress para acessar a memória armazenado em $t0

lw $17, 0($t0) # load de x1 para $s1
lw $18, 4($t0) # load de x1 para $s2
lw $19, 8($t0) # load de x1 para $s3
lw $20, 12($t0) # load de x1 para $s4

.data
x1: .word 15
x2: .word 25
x3: .word 13
x4: .word 17
