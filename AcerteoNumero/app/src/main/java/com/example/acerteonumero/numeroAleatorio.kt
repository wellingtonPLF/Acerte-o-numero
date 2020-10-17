package com.example.acerteonumero

class numeroAleatorio (inicio: Int, fim: Int) {
    private var number = (inicio..fim).random()
    private var divisorComum = mutableListOf<Int>()

    fun divisores() : List<Int>{
        for(x in 1..10){
            if(number%x == 0){
                divisorComum.add(x)
            }
        }
        return divisorComum
    }

    fun imparOrpar() : String{
        if(number%2 == 0){
            return "par"
        }
        else{
            return "impar"
        }
    }

    fun contador(): Int{
        return divisorComum.count()
    }

    fun getnumber() : Int{
        return number
    }
}