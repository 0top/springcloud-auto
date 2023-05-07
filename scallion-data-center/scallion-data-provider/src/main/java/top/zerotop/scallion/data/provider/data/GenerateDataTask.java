package top.zerotop.scallion.data.provider.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.zerotop.common.task.TaskMessage;

import java.util.Map;

@Component
public class GenerateDataTask {
    @Autowired
    private PsychokinesisDataProvider psychokinesisDataProvider;

    public void execTask(TaskMessage taskMessage) {
        Map<String, Object> params = taskMessage.getParams();
        String geneDataType = params != null ? (String) params.get("geneDataType") : "";
        if (geneDataType != null) {
            psychokinesisDataProvider.generateSentence();
        } else {
            psychokinesisDataProvider.generateSentence();
        }
    }
}
