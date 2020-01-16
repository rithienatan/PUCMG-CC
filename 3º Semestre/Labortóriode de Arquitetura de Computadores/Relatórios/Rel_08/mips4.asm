# x mapeado em $s1
.text
.globl teste
teste:

addi $8, $zero, 0x1001
sll $8, $8, 16 # valor do adress para acessar a memória armazenado em $t0

lw $16, 0($8) # load de x1 para $s0
lw $17, 4($8) # load de x2 para $s1
lw $18, 8($8) # load de x3 para $s2
lw $19, 12($8) # load de x4 para $s3

nop # sll $zero, $zero, 0

add $9, $16, $17 # $t1 = $s0 + $s1
add $9, $18, $9 # $t1 = $s2 + $t1
add $9, $19, $9 # $t1 = $s3 + $t1

sw $9, 16($8) # salva o resultado de $t1 em soma

.data
x1: .word 15
x2: .word 25
x3: .word 13
x4: .word 17
soma: .word -1
