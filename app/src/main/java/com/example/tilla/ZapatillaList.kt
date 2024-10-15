package com.example.tilla

    class ZapatillaList {
        companion object {
            fun getZapatilla(): List<Zapatilla> {
                val shoeList = mutableListOf<Zapatilla>()
                shoeList.add(Zapatilla("Converse Negra", "https://i.postimg.cc/6qMG3CNY/pngwing-com-2.png", 72.999))
                shoeList.add(Zapatilla("Puma Urbana", "https://i.postimg.cc/44cBWcPb/pngwing-com-4.png", 79.999))
                shoeList.add(Zapatilla("Adidas Blanca", "https://i.postimg.cc/wTV5rQmJ/pngwing-com-5.png", 23.799))
                shoeList.add(Zapatilla("NB Verde", "https://i.postimg.cc/mgpYLZVg/pngwing-com-6.png", 24.999))
                shoeList.add(Zapatilla("Skechers Gris", "https://i.postimg.cc/PxYYQWHC/pngwing-com-7.png", 37.495))
                shoeList.add(Zapatilla("Nike Air Max", "https://i.postimg.cc/XJGQSBbW/pngwing-com-3.png", 74.879))
                shoeList.add(Zapatilla("Fila Blanca", "https://i.postimg.cc/xTcTr0kR/pngwing-com-8.png", 45.675))
                shoeList.add(Zapatilla("Reebok Naranja", "https://i.postimg.cc/FRrNTm50/pngwing-com-9.png", 50.983))
                shoeList.add(Zapatilla("Vans rojo", "https://i.postimg.cc/J0tmWqhn/pngwing-com-10.png", 83.993))
                shoeList.add(Zapatilla("Under Armour Gris", "https://i.postimg.cc/d3XFQy79/pngwing-com-11.png", 29.995))
                shoeList.add(Zapatilla("DC Negra", "https://i.postimg.cc/yd8CFPcP/pngwing-com-12.png", 69.991))
                shoeList.add(Zapatilla("Umbro Azul", "https://i.postimg.cc/MZhK8CyJ/pngwing-com-13.png", 29.991))
                shoeList.add(Zapatilla("Brooks Azul", "https://i.postimg.cc/pdXPZRtz/pngwing-com-14.png", 39.991))
                shoeList.add(Zapatilla("Nike Air", "https://i.postimg.cc/x8HQCdKD/pngwing-com-15.png", 99.995))
                return shoeList
            }
        }
    }
