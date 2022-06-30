//package edu.miu.spring_data.helper;
//
//import edu.miu.spring_data.dto.ProductDto;
//import edu.miu.spring_data.entity.Product;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Component
//public class ListMapper <T , E>{
//
//    @Autowired
//    ModelMapper modelmapper ;
//
//    public List<?> mapList(List<T> list, E convertTo)
//    {
//        return list.stream()
//                .map(l-> modelmapper.map(l , convertTo.getClass()))
//                .collect(Collectors.toList());
//    }
//}
