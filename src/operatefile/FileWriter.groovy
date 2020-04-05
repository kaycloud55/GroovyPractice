package operatefile

/**
 * Created by jiangyunkai on 2020/4/4
 * desc:
 */

def saveObject(Object object, String path) {
    try {
        //首先创建文件
        def desFile = new File(path)
        if (!desFile.exists()) {
            desFile.createNewFile()
        }
        desFile.withObjectOutputStream {
            it.writeObject(object)
        }

    } catch (Exception e) {

    }
}


