package com.yaojiafeng.test.qlexpress;

import com.ql.util.express.*;
import com.ql.util.express.instruction.detail.Instruction;
import com.ql.util.express.instruction.detail.InstructionCallSelfDefineFunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * 自定义配置函数解析调用
 *
 * Created by yaojiafeng on 2018/8/6 下午8:14.
 */
public class QLExpressTest {

    public static void main(String[] args) throws Exception {

        DefaultContext<String, Object> context = new DefaultContext<String, Object>();
        ExpressRunner runner = new ExpressRunner();

        List<String> fun = new ArrayList<>();

        InstructionSet instructionSet = runner.parseInstructionSet("shopAreaIn(19)&&itemAreaIn(19)");
        if (instructionSet != null && instructionSet.getCurrentPoint() > 0) {
            for (int i = 0; i <= instructionSet.getCurrentPoint(); i++) {
                Instruction instruction = instructionSet.getInstruction(i);
                if (instruction.getClass().getName().indexOf("InstructionCallSelfDefineFunction") > 0) {
                    InstructionCallSelfDefineFunction instructionFunction = (InstructionCallSelfDefineFunction) instruction;
                    context.put("shopAreaList", Arrays.asList("19"));
                    fun.add(instructionFunction.getFunctionName());
                }
            }
        }

        runner.addFunction("shopAreaIn", new ContainShopAreaHandle());
        runner.addFunction("itemAreaIn", new ContainShopAreaHandle());

        Boolean r = (Boolean) runner.execute("shopAreaIn(19)&&itemAreaIn(19)", context, null, false, true);
        System.out.println(r);
    }


    public static class ContainShopAreaHandle extends Operator {

        @Override
        public OperateData executeInner(InstructionSetContext context, ArraySwap arraySwap) throws Exception {
            Object parameter = context.get("shopAreaList");
            List<String> parameterList = (List<String>) parameter;
            Boolean returnValue = containList(arraySwap, context, parameterList);
            return new OperateData(returnValue, returnValue.getClass());
        }

        public Boolean containList(ArraySwap arraySwap, InstructionSetContext context, List<String> values) throws Exception {
            if (values == null || values.size() == 0) {
                return Boolean.FALSE;
            } else {
                for (int i = 0; i < arraySwap.length; i++) {
                    String data = arraySwap.get(i).getObject(context).toString();
                    for (String value : values) {
                        if (value.trim().equals(data.trim())) {
                            return Boolean.TRUE;
                        }
                    }
                }
            }
            return Boolean.FALSE;
        }

        @Override
        public Object executeInner(Object[] objects) throws Exception {
            return null;
        }
    }
}
