public class Vector3d extends Object{

    private float x,y,z;

    public Vector3d(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }


    /*  Должны соблюдаться следующие принципы:
        1. Рефлексивность : o = obj1; obj1.equals(o) == True -> o.equals(obj1) == True
        2. Симметричность: obj1.equals(obj2) == True -> obj2.equals(obj1) == True
        3. Транзитивность:  obj1.equals(obj2) && obj1.equals(obj3) -> obj3.equals(obj2) == True
        4. Непротиворечивость: многократные вызовы не меняют результаты последующих.
        5. Сравнение с null: obj.equals(null) == false - всегда!

    */

    @Override
    public boolean equals(Object obj) {

        //самый простой случай
        if (this == obj) {
            return true;
        }
        
        //Проверка на null и совместимость типов
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        
        //Приведение типа и проверка внутренних знчений.
        Vector3d other = (Vector3d) obj;
        return other.x == this.x && other.y == this.y && other.z == this.z ;
    }

    public float getX(){
        return this.x;
    }

    public float getY(){
        return this.y;
    }

    public float getZ(){
        return this.z;
    }

}