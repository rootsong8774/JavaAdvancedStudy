package Chap01.sec07.main02;

public class ProductVo {

    @Anno1(name = "name", value = 1, child = @Child(value = 1), dataType = DataType.A)
    private String productNo;
    @Anno2(names = {"name1", "name2"}, values = {1, 2}, children = {@Child(value = 1),
        @Child(value = 2)}, dataTypes = {DataType.B, DataType.C})
    private String productName;


}
